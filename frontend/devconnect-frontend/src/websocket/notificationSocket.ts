import  {store}  from '../store'
import { addNotification } from '../features/notifications/notificationSlice'

interface NotificationPayload {
  message: string
  [key: string]: any
}

export const initNotificationSocket = (): void => {
  const socket = new WebSocket('ws://localhost:8080/ws/notifications')

  socket.onmessage = (event: MessageEvent) => {
    const data: NotificationPayload = JSON.parse(event.data)
    store.dispatch(addNotification(data))
  }

  socket.onopen = () => console.log('🔔 Notification socket connected')
  socket.onerror = (err) => console.error('Notification socket error:', err)
}
