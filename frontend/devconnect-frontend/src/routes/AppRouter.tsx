import React, { type JSX } from 'react'
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'
import { useSelector } from 'react-redux'
import type { RootState } from '../store'

import Login from '../features/auth/Login'
import Register from '../features/auth/Register'
import Dashboard from '../features/Dashboard/Dashboard'
import KanbanBoard from '../features/kanban/KanbanBoard'
import ChatPage from '../features/chat/Chatpage'
import WorkspacePage from '../features/workspace/WorkspacePage'
import EditorRoom from '../features/editor/EditorRoom'
import NotificationPanel from '../features/notifications/NotificationPanel'
import NotFound from '../components/NotFound'

const PrivateRoute: React.FC<{ children: JSX.Element }> = ({ children }) => {
  const token = useSelector((state: RootState) => state.auth.token)
  return token ? children : <Navigate to="/login" replace />
}

const AppRouter: React.FC = () => (
  <Router>
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />

      <Route path="/dashboard" element={<PrivateRoute><Dashboard /></PrivateRoute>} />
      <Route path="/kanban" element={<PrivateRoute><KanbanBoard /></PrivateRoute>} />
      <Route path="/chat" element={<PrivateRoute><ChatPage /></PrivateRoute>} />
      <Route path="/workspace/:id" element={<PrivateRoute><WorkspacePage /></PrivateRoute>} />
      <Route path="/editor" element={<PrivateRoute><EditorRoom /></PrivateRoute>} />
      <Route path="/notifications" element={<PrivateRoute><NotificationPanel /></PrivateRoute>} />

      <Route path="/" element={<Navigate to="/dashboard" replace />} />
      <Route path="*" element={<NotFound />} />
    </Routes>
  </Router>
)

export default AppRouter
