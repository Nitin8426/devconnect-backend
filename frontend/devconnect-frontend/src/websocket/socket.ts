let socket: WebSocket | null = null

export const initSocket = (): WebSocket => {
  if (!socket) {
    socket = new WebSocket('ws://localhost:8080/ws')
  }
  return socket
}

export const getSocket = (): WebSocket | null => socket
