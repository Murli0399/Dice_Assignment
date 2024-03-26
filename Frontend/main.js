
document.getElementById("add").addEventListener('click', () => {
    let city = document.getElementById('cityinput').value;
    searchW(city);
})

function searchW(city) {

    fetch(`http://localhost:8080/weather/forecast-summary?city=${city}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Forecast Summary:', data);
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });

}