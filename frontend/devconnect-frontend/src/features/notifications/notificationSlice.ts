import { createSlice, type PayloadAction } from '@reduxjs/toolkit';

// ✅ Export the interface
export interface Notification {
  message: string;
  [key: string]: any;
}

const notificationSlice = createSlice({
  name: 'notifications',
  initialState: [] as Notification[],
  reducers: {
    addNotification: (state, action: PayloadAction<Notification>) => {
      state.push(action.payload);
    },
    clearNotifications: () => [],
  },
});

export const { addNotification, clearNotifications } = notificationSlice.actions;
export default notificationSlice.reducer;
