// src/pages/Landing.tsx
import React from 'react'
import { Link } from 'react-router-dom'

const Landing: React.FC = () => {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gradient-to-r from-indigo-600 to-purple-600 text-white text-center px-4">
      <h1 className="text-5xl font-bold mb-4">Welcome to DevConnect 🚀</h1>
      <p className="text-xl mb-8 max-w-xl">
        Collaborate with your team, manage projects, and code together — all in one place.
      </p>
      <div className="flex space-x-4">
        <Link to="/login" className="bg-white text-indigo-600 px-6 py-2 rounded shadow hover:bg-gray-100 font-semibold">
          Login
        </Link>
        <Link to="/register" className="border border-white px-6 py-2 rounded hover:bg-white hover:text-indigo-600 font-semibold">
          Register
        </Link>
      </div>
    </div>
  )
}

export default Landing
