import axios from "axios";

// db.json file, when not using spring api
const baseUrl = "http://localhost:3000/todos"; 
// const baseUrl = "/api/todos"

const getAll = () => {
    try {
        return axios.get(`${baseUrl}`)
    } catch (e) {
        console.error("Error retrieving todos data")
        throw e;
    }
}

export const TodoService = {
    getAll,
}