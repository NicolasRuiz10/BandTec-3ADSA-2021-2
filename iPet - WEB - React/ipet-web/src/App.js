import './App.css';
import React from 'react';
import Routes from "./Router/Router";

import { AuthProvider } from './hooks/Context.jsx';

function App() {
  return (
    <AuthProvider>
      <Routes />
    </AuthProvider>
  )
};
export default App;
