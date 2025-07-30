import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import axios from '../../lib/axios'

interface Workspace {
  id: string
  name: string
  description?: string
}

const WorkspacePage: React.FC = () => {
  const { id } = useParams<{ id: string }>()
  const [workspace, setWorkspace] = useState<Workspace | null>(null)

  useEffect(() => {
    if (id) {
      axios.get<Workspace>(`/workspaces/${id}`)
        .then((res: { data: Workspace }) => setWorkspace(res.data))
        .catch((err: unknown) => console.error('Error fetching workspace:', err))
    }
  }, [id])

  if (!workspace) {
    return <div className="p-4">Loading...</div>
  }

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-2">{workspace.name}</h1>
      {workspace.description && <p className="text-gray-600 mb-4">{workspace.description}</p>}
      {/* Future workspace features: chat, editor, tasks, etc. */}
    </div>
  )
}

export default WorkspacePage
