// src/features/issues/issueSlice.ts
import { createSlice } from '@reduxjs/toolkit';
import type { PayloadAction } from '@reduxjs/toolkit';

export interface Issue {
  id: number;
  title: string;
  status: 'open' | 'closed';
}

interface IssueState {
  issues: Issue[];
  loading: boolean;
  error: string | null;
}

const initialState: IssueState = {
  issues: [
    { id: 1, title: 'WebSocket not connecting', status: 'open' },
    { id: 2, title: 'JWT token not refreshing', status: 'closed' },
  ],
  loading: false,
  error: null,
};

const issueSlice = createSlice({
  name: 'issue',
  initialState,
  reducers: {
    addIssue: (state, action: PayloadAction<Issue>) => {
      state.issues.push(action.payload);
    },
    updateIssueStatus: (
      state,
      action: PayloadAction<{ id: number; status: Issue['status'] }>
    ) => {
      const issue = state.issues.find((i) => i.id === action.payload.id);
      if (issue) {
        issue.status = action.payload.status;
      }
    },
    setLoading: (state, action: PayloadAction<boolean>) => {
      state.loading = action.payload;
    },
    setError: (state, action: PayloadAction<string | null>) => {
      state.error = action.payload;
    },
  },
});

export const {
  addIssue,
  updateIssueStatus,
  setLoading,
  setError,
} = issueSlice.actions;

export default issueSlice.reducer;
