// src/layouts/AuthLayout.tsx
import { Outlet } from 'react-router-dom'

const AuthLayout = () => {
  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-50">
      <div className="w-full max-w-md p-8 bg-white shadow-md rounded-xl">
        <Outlet />
      </div>
    </div>
  )
}

export default AuthLayout
