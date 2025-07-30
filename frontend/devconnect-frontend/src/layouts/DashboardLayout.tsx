// src/layouts/DashboardLayout.tsx
// src/layouts/DashboardLayout.tsx
import type { ReactNode } from 'react';
import { Link } from 'react-router-dom';

const DashboardLayout = ({ children }: { children: ReactNode }) => {
  return (
    <div className="flex h-screen">
      <aside className="w-64 bg-gray-800 text-white p-6">
        <h1 className="text-2xl font-bold mb-8">DevConnect</h1>
        <nav className="flex flex-col gap-4">
          <Link to="/dashboard" className="hover:underline">Dashboard</Link>
          <Link to="/kanban" className="hover:underline">Kanban</Link>
          <Link to="/chat" className="hover:underline">Chat</Link>
          <Link to="/editor" className="hover:underline">Editor</Link>
          <Link to="/ai" className="hover:underline">AI Assistant</Link>
        </nav>
      </aside>
      <main className="flex-1 bg-gray-100 p-6 overflow-y-auto">
        {children}
      </main>
    </div>
  );
};

export default DashboardLayout;
