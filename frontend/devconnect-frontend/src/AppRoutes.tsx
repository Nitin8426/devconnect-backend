import { Routes, Route } from 'react-router-dom'
import Landing from './pages//Landing'
import Login from './features/auth/Login'
import Register from './features/auth/Register'
import Dashboard from './features/Dashboard/Dashboard'
import KanbanBoard from './features/kanban/KanbanBoard'
import IssueTracker from './features/issues/issueTracker'
import ChatRoom from './features/chat/ChatRoom'
import EditorRoom from './features/editor/EditorRoom'
import NotificationPanel from './features/notifications/NotificationPanel'
import AuthLayout from './layouts/AuthLayout'

const AppRouter = () => {
  return (
    <Routes>
      <Route path="/" element={<Landing />} />
      <Route element={<AuthLayout />}>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
      </Route>
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="/kanban" element={<KanbanBoard />} />
      <Route path="/issues" element={<IssueTracker />} />
      <Route path="/chat" element={<ChatRoom />} />
      <Route path="/editor" element={<EditorRoom />} />
      <Route path="/notifications" element={<NotificationPanel />} />
    </Routes>
  )
}

export default AppRouter
