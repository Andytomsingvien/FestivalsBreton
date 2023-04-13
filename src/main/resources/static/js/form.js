/**

 Initialise la carte et les événements associés.

 @function

 @returns {void}
 */
function initMap() {
// Créer une instance de la carte Leaflet centrée sur la Bretagne avec un zoom de 8
    let map = L.map('map').setView([47.8607, -2.9375], 8);
    let marker;

    /**

     Initialise la tuile OpenStreetMap et définit le curseur de la carte.
     @function
     @returns {void}
     */
    $(document).ready(function () {
// Ajouter une couche de tuile OpenStreetMap à la carte
        L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '© <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);
// Définir le curseur de la carte comme une croix
        map.getContainer().style.cursor = 'crosshair';
    });
    /**

     Ajoute un marqueur sur la carte et met à jour les champs de latitude et de longitude.
     @function
     @param {Object} e - L'événement click sur la carte.
     @returns {void}
     */
    function onMapClick(e) {
// Supprimer l'ancien marqueur s'il existe
        if (marker) {
            map.removeLayer(marker);
        }
// Mettre à jour les champs de latitude et longitude du formulaire
        document.getElementById('lat').value = e.latlng.lat.toFixed(6);
        document.getElementById('lon').value = e.latlng.lng.toFixed(6);
// Ajouter un nouveau marqueur à l'emplacement cliqué
        marker = L.marker(e.latlng).addTo(map);
    }
// Ajouter un événement click à la carte pour ajouter le marqueur et mettre à jour les champs
    map.on('click', onMapClick);
}