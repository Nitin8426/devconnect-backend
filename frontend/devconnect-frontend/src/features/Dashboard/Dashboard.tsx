// src/features/dashboard/Dashboard.tsx
import type { FC } from 'react';
import { Link } from 'react-router-dom'

const Dashboard: FC = () => {
  const cards = [
    { to: '/kanban', title: 'Kanban Board' },
    { to: '/issues', title: 'Issue Tracker' },
    { to: '/chat', title: 'Chat Room' },
    { to: '/editor', title: 'Code Editor' },
    { to: '/notifications', title: 'Notifications' },
  ]

  return (
    <div className="p-8">
      <h1 className="text-3xl font-bold mb-4">Welcome to DevConnect 🚀</h1>
      <div className="grid gap-4 grid-cols-1 sm:grid-cols-2 lg:grid-cols-3">
        {cards.map(({ to, title }) => (
          <Link key={to} to={to} className="card">
            {title}
          </Link>
        ))}
      </div>
    </div>
  )
}

export default Dashboard
