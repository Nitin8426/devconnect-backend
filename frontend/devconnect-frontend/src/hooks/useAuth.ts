// src/hooks/useAuth.ts
import { useSelector } from 'react-redux'
import type { RootState } from '../store'

export const useAuth = () => {
  const auth = useSelector((state: RootState) => state.auth)
  const isAuthenticated = !!auth.token
  const user = auth.user

  return {
    isAuthenticated,
    token: auth.token,
    user,
  }
}
