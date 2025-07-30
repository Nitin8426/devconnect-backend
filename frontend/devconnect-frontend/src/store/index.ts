import { configureStore } from '@reduxjs/toolkit';
import { combineReducers } from 'redux';

import authReducer from '../features/auth/authSlice';
import kanbanReducer from '../features/kanban/KanbanSlice';
import issueReducer from '../features/issues/issueSlice';

const rootReducer = combineReducers({
  auth: authReducer,
  kanban: kanbanReducer,
  issue: issueReducer,
});

const store = configureStore({
  reducer: rootReducer,
});

export type RootState = ReturnType<typeof rootReducer>;
export type AppDispatch = typeof store.dispatch;

export default store;
