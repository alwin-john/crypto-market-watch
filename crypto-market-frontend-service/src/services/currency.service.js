import httpClient from "../http-common";

const getAll = () => {
    return httpClient.get('/crypto/api/v1/currency-rates');
}

export default { getAll };
