import React from 'react';
import { createRoot } from 'react-dom/client';
import App from './App.jsx';

import styles from './scss/_games.scss'

const container = document.getElementById('root');
const root = createRoot(container);

root.render(
  <App/>
);

/*
import { createRoot } from 'react-dom/client';
const container = document.getElementById('app');
const root = createRoot(container); // createRoot(container!) if you use TypeScript
root.render(<App tab="home" />);
*/