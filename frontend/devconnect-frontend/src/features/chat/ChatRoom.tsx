// src/features/chat/ChatRoom.tsx
import { useState } from 'react';

import type { FC, ChangeEvent } from 'react';


interface Message {
  sender: string
  text: string
}

const ChatRoom: FC = () => {
  const [messages, setMessages] = useState<Message[]>([
    { sender: 'Alice', text: 'Hey there!' },
    { sender: 'You', text: 'Hi Alice 👋' },
  ])
  const [input, setInput] = useState('')

  const sendMessage = () => {
    if (!input.trim()) return
    setMessages((prev) => [...prev, { sender: 'You', text: input }])
    setInput('')
  }

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    setInput(e.target.value)
  }

  return (
    <div className="p-6 flex flex-col h-screen">
      <h2 className="text-2xl font-semibold mb-4">Chat Room</h2>
      <div className="flex-1 overflow-y-auto mb-4 space-y-2">
        {messages.map((msg, i) => (
          <div
            key={i}
            className={`p-2 rounded ${
              msg.sender === 'You' ? 'bg-blue-100 self-end' : 'bg-gray-200 self-start'
            }`}
          >
            <strong>{msg.sender}:</strong> {msg.text}
          </div>
        ))}
      </div>
      <div className="flex gap-2">
        <input
          value={input}
          onChange={handleChange}
          className="input flex-1"
          placeholder="Type a message..."
        />
        <button onClick={sendMessage} className="btn">
          Send
        </button>
      </div>
    </div>
  )
}

export default ChatRoom
