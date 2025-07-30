// src/features/issues/IssueTracker.tsx

import { useSelector } from 'react-redux'
import type { FC } from 'react'
import type { RootState } from '../../store'
import type { Issue } from './issueSlice'

const IssueTracker: FC = () => {
  // Access issues from the Redux store
  const issues = useSelector((state: RootState) => state.issue.issues)

  return (
    <div className="p-6">
      <h2 className="text-2xl font-semibold mb-4">Issue Tracker</h2>

      <table className="min-w-full table-auto border-collapse border">
        <thead>
          <tr className="bg-gray-100 text-left">
            <th className="p-2 border">ID</th>
            <th className="p-2 border">Title</th>
            <th className="p-2 border">Status</th>
          </tr>
        </thead>

        <tbody>
          {issues.map((issue: Issue) => (
            <tr key={issue.id} className="hover:bg-gray-50">
              <td className="p-2 border">{issue.id}</td>
              <td className="p-2 border">{issue.title}</td>
              <td className="p-2 border">
                <span
                  className={`text-sm px-2 py-1 rounded ${
                    issue.status === 'open'
                      ? 'bg-green-200 text-green-800'
                      : 'bg-red-200 text-red-800'
                  }`}
                >
                  {issue.status}
                </span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default IssueTracker
