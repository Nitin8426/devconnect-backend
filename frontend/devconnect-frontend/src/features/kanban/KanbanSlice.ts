import { createSlice } from '@reduxjs/toolkit'
import type { PayloadAction } from '@reduxjs/toolkit'


export interface KanbanState {
  todo: string[]
  inProgress: string[]
  done: string[]
}

const initialState: KanbanState = {
  todo: ['Login Page UI', 'Setup Redux Toolkit'],
  inProgress: ['Editor CRDT Integration'],
  done: ['Landing Page', 'Auth Setup'],
}

const kanbanSlice = createSlice({
  name: 'kanban',
  initialState,
  reducers: {
    addTask: (state, action: PayloadAction<{ status: keyof KanbanState; task: string }>) => {
      state[action.payload.status].push(action.payload.task)
    },
  },
})

export const { addTask } = kanbanSlice.actions
export default kanbanSlice.reducer
