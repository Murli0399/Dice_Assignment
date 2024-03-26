
document.getElementById("add").addEventListener('click', () => {
    let city = document.getElementById('cityinput').value;
    searchW(city);
})

function searchW(city) {

    fetch(`diceassignment-production.up.railway.app/weather/forecast-summary?city=${city}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Forecast Summary:', data);
            document.getElementById("cityoutput").innerText = data.location.name;
            document.getElementById("description").innerText = data.location.timezone;
            document.getElementById("temp").innerText = data.forecast.items[0].temperature.max;
            document.getElementById("wind").innerText = data.forecast.items[0].wind.max;
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });

}