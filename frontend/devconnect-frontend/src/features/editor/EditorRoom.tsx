import { useEffect, useRef } from 'react';
import Editor from '@monaco-editor/react';
import type { OnMount } from '@monaco-editor/react';
import type * as monaco from 'monaco-editor';
import * as Y from 'yjs';
import { WebsocketProvider } from 'y-websocket';
import { MonacoBinding } from 'y-monaco';

const EditorRoom = () => {
  const editorRef = useRef<monaco.editor.IStandaloneCodeEditor | null>(null);

  useEffect(() => {
    const ydoc = new Y.Doc();
    const provider = new WebsocketProvider('ws://localhost:1234', 'devconnect-room', ydoc);
    const yText = ydoc.getText('monaco');

    provider.awareness.setLocalStateField('user', {
      name: 'DevUser',
      color: '#29b6f6',
    });

    if (editorRef.current) {
      const model = editorRef.current.getModel();
      if (model) {
        new MonacoBinding(yText, model, new Set([editorRef.current]), provider.awareness);
      }
    }

    return () => {
      provider.destroy();
    };
  }, []);

  const handleEditorMount: OnMount = (editor) => {
    editorRef.current = editor;
  };

  return (
    <div className="h-screen">
      <Editor
        height="100%"
        defaultLanguage="javascript"
        defaultValue="// Start coding together..."
        onMount={handleEditorMount}
      />
    </div>
  );
};

export default EditorRoom;
