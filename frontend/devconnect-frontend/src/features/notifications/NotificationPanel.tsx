import type { FC } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { clearNotifications } from './notificationSlice';
import type { RootState } from '../../store';

const NotificationPanel: FC = () => {
  const dispatch = useDispatch();

  const notifications = useSelector(
    (state: RootState) => state.notifications
  );

  const handleClear = () => {
    dispatch(clearNotifications());
  };

  return (
    <div className="p-4 bg-white shadow rounded-lg">
      <div className="flex justify-between items-center mb-4">
        <h2 className="text-lg font-bold text-gray-800">Notifications</h2>
        <button
          onClick={handleClear}
          className="text-sm text-blue-600 hover:underline"
        >
          Clear All
        </button>
      </div>

      <ul className="space-y-2">
        {notifications.length === 0 ? (
          <li className="text-gray-500">No notifications</li>
        ) : (
          notifications.map((notification, index) => (
            <li
              key={index}
              className="p-3 bg-gray-100 rounded shadow-sm flex items-start text-sm"
            >
              <span className="mr-2">🔔</span>
              <span>{notification.message}</span>
            </li>
          ))
        )}
      </ul>
    </div>
  );
};

export default NotificationPanel;
