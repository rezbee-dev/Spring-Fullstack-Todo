import {  BrowserRouter, Routes, Route, createBrowserRouter, createRoutesFromElements, RouterProvider  } from "react-router-dom"
import CountryPage from "./pages/CountryPage"
import HomePage from "./pages/HomePage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />}/>
        <Route path="/country" element={<CountryPage />}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App;