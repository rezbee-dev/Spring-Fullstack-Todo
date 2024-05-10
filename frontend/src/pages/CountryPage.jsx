import { useState, useEffect } from "react";
import { CountryService } from "../modules/sample/CountryService";
import CountryComponent from "../modules/sample/CountryComponent";

const CountryPage = () => {
    const [countries, setCountries ] = useState([]);

    useEffect(() => {
        const fetchCountries = async () => {
            const data = await CountryService.getAll();
            setCountries(data.data)
        }

        fetchCountries();
    }, [])

    if(countries.length == 0)
        return <p>No Countries Available</p>
    
    return (
        <div>
            {countries.map((c) => <CountryComponent key={c.id} id={c.id} name={c.name} />)}
        </div>
    )
}

export default CountryPage