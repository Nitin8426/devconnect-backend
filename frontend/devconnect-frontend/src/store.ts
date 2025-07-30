import { configureStore } from '@reduxjs/toolkit';
import authReducer from './features/auth/authSlice';
import kanbanReducer from './features/kanban/KanbanSlice';
import notificationReducer from './features/notifications/notificationSlice';
import issueReducer from './features/issues/issueSlice'; // ✅ Add this line

export const store = configureStore({
  reducer: {
    auth: authReducer,
    kanban: kanbanReducer,
    notifications: notificationReducer,
    issue: issueReducer, // ✅ Add this line
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
