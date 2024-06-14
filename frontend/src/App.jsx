import {  BrowserRouter, Routes, Route } from "react-router-dom"
import CountryPage from "./pages/CountryPage"
import HomePage from "./pages/HomePage";
import TodoPage from "./modules/todo/TodoPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />}/>
        <Route path="/country" element={<CountryPage />}/>
        <Route path="/todo" element={<TodoPage />}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App;