import { useState, useEffect } from "react";
import { TodoService } from "./TodoService";
import TodoComponent from "./TodoComponent";

const TodoPage = () => {
    const [todos, setTodos ] = useState([]);

    useEffect(() => {
        const fetchTodos = async () => {
            const data = await TodoService.getAll();
            setTodos(data.data);
        }

        fetchTodos();
    }, [])

    if(todos.length == 0) {
        return <p>No items to display</p>
    }

    return (
        <div>
            {todos.map((t) => <TodoComponent key={t.id} todo={t} />)}
        </div>
    )
}

export default TodoPage;