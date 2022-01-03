import { useEffect, useState } from 'react';
import './App.css';
import currencyService from './services/currency.service';

const App = () => {

  const [supportedCurrencyData, setCryptoCurrency] = useState({});
  const [selectedCurrency, setSelectedCurency] = useState("");
  const [ipAddress, setIpAddress] = useState("");
  const [defaultIp, setDefaultIp] = useState("");
  const [isLoaded, setIsLoaded]  = useState(true);
  const [currency, setCurrencyData]  = useState({});
  useEffect(() => {
    currencyService.getAll()
      .then(response => {
        console.log('Printing employees data', response.data);
        setCryptoCurrency(response.data);
        setDefaultIp(response.data.defaultIp);
        setIsLoaded(false);
      })
      .catch(error => {
        console.log('Something went wrong', error);
      })    
  }, []);

  function selectCryptoCurrency(e) {
    console.log("Selected currency", e.target.value);
    const currency = e.target.value;
    setSelectedCurency(currency);
    searchForCurrencyRate(currency, ipAddress);
  }

  function handleChange(e){
    console.log("input", e.target.value);
    const ip = e.target.value;
    setIpAddress(ip);
    searchForCurrencyRate(selectedCurrency, ip);
  }

  function searchForCurrencyRate( cryptoCurrency, ip){
    if(ip === "" || ip === undefined){
      ip = defaultIp;
    }
   const currencyList = supportedCurrencyData.currencyDtoList
    .filter((data) => data.cryptoCurrencyName === cryptoCurrency).filter((data) => data.ipAddress === ip);
    console.log(currencyList);
    setCurrencyData(currencyList);
  }

  if (isLoaded) {
    return <div className="App">Loading...</div>;
  }


  return (
    <div>
      <div className="App">
        <h1>Crypto Market Watch</h1>

        <div className="Container">
          <select
            name="currency"
            onChange={e => selectCryptoCurrency(e)}
            value={selectedCurrency}
          >
          <option value="">Select the currency</option>
           {supportedCurrencyData.currencyDtoList.map((data) => (
              <option key={data.id} value={data.cryptoCurrencyName}>
                {data.cryptoCurrencyName}
              </option>
          ))}
          </select>
          <div className="space">
            <label>
              IP:
              <input type="text" value={ipAddress} onChange={ e => handleChange(e)} />
            </label>
          </div>
          <div>
            { currency.length>=1 ? <h4> current unit price is {currency[0].unitPriceCurrencyCode} {currency[0].unitPrice} </h4>
                                 : <h4> NO value found for {defaultIp} </h4>  }
          </div>
        </div>
      </div>
    </div>
  );
}
export default App;
