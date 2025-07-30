import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./devconnect-frontend/index.html",
    "./devconnect-frontend/src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {},
  },
  plugins: [],
};

export default config;
