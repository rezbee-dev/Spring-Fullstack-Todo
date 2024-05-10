import axios from "axios";

const baseUrl = "http://localhost:3000/countries";

const getAll = () => {
    try {
        return axios.get(`${baseUrl}`)
    } catch (e) {
        console.error("Error retrieving countries data");
        throw e;
    }
}

export const CountryService = {
    getAll,
}