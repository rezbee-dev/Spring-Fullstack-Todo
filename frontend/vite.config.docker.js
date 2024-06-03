import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    // allows listening on all addresses (for backend API during dev ?)
    host: '0.0.0.0',
    port: 8081,
    // exits app if port already in use, instead of trying next available port
    strictPort: true, 
    // overcomes cors issues
    // allows for using relative URL in API calls
    // see https://github.com/http-party/node-http-proxy#options
    proxy: {
      "/api": {
        // create alternate vite.config file that uses localhost
        //   for when docker is not used
        // target: "http://localhost:8080",
        target: "http://Spring-Todo-Api:8080",
        changeOrigin: true,
        secure: false
      }
    },
    watch: {usePolling: true},
    test: {
      globals: true,
      environment: 'jsdom',
      setupFiles: './src/tests/setup.js'
    }
  }
})
