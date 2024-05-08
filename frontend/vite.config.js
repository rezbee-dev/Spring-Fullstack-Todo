import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    // allows listening on all addresses (for backend API during dev ?)
    host: true,
    port: 8081,
    // exits app if port already in use, instead of trying next available port
    strictPort: true, 
    // overcomes cors issues
    // allows for using relative URL in API calls
    // see https://github.com/http-party/node-http-proxy#options
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        changeOrigin: true,
        secure: false
      }
    },
    test: {
      globals: true,
      environment: 'jsdom',
      setupFiles: './src/tests/setup.js'
    }
  }
})
