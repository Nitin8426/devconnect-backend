import type { FC } from 'react'
import { useSelector } from 'react-redux'
import type { RootState } from '../../store'
import type { KanbanState } from './KanbanSlice'

const KanbanBoard: FC = () => {
  const { todo, inProgress, done } = useSelector((state: RootState) => state.kanban)

  const columns: Array<{ status: keyof KanbanState; title: string }> = [
    { status: 'todo', title: 'To Do' },
    { status: 'inProgress', title: 'In Progress' },
    { status: 'done', title: 'Done' },
  ]

  return (
    <div className="p-6">
      <h2 className="text-2xl font-semibold mb-4">Kanban Board</h2>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        {columns.map(({ status, title }) => (
          <div key={status} className="bg-gray-100 rounded-lg shadow p-4">
            <h3 className="text-lg font-bold mb-2">{title}</h3>
            <div className="space-y-2">
              {getTasks(status).map((task, index) => (
                <div key={index} className="bg-white p-3 rounded shadow text-sm">
                  {task}
                </div>
              ))}
            </div>
          </div>
        ))}
      </div>
    </div>
  )

  function getTasks(status: keyof KanbanState): string[] {
    return { todo, inProgress, done }[status]
  }
}

export default KanbanBoard
