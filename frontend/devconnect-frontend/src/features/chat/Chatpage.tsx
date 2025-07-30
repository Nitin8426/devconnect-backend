import { useState, useEffect } from 'react';
import type { FC, ChangeEvent } from 'react';
import { initSocket, getSocket } from '../../websocket/socket'

interface Message {
  id: string
  sender: string
  text: string
  createdAt: string
}

const ChatPage: FC = () => {
  const [messages, setMessages] = useState<Message[]>([])
  const [input, setInput] = useState('')

  useEffect(() => {
    const socket = initSocket()
    socket.onmessage = (e: MessageEvent) => {
      const msg = JSON.parse(e.data) as Message
      setMessages(prev => [...prev, msg])
    }
    return () => socket.close()
  }, [])

  const handleSubmit = () => {
    if (!input.trim()) return
    const socket = getSocket()
    const msg = { id: crypto.randomUUID(), sender: 'You', text: input, createdAt: new Date().toISOString() }
    socket?.send(JSON.stringify(msg))
    setMessages(prev => [...prev, msg])
    setInput('')
  }

  return (
    <div className="p-6 flex flex-col h-screen">
      <h2 className="text-2xl font-semibold mb-4">Chat Room</h2>
      <div className="flex-1 overflow-y-auto mb-4 space-y-2">
        {messages.map(msg => (
          <div
            key={msg.id}
            className={`p-2 rounded ${msg.sender === 'You' ? 'bg-blue-100 self-end' : 'bg-gray-200 self-start'}`}
          >
            <strong>{msg.sender}</strong>: {msg.text}
          </div>
        ))}
      </div>
      <div className="flex gap-2">
        <input
          value={input}
          onChange={(e: ChangeEvent<HTMLInputElement>) => setInput(e.target.value)}
          className="input flex-1"
          placeholder="Type a message..."
        />
        <button onClick={handleSubmit} className="btn">Send</button>
      </div>
    </div>
  )
}

export default ChatPage
