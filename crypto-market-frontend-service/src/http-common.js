import axios from "axios";

export default axios.create({
    baseURL: 'http://backend/zoo',
    headers: {
        'Content-Type': 'application/json'
    }
});
