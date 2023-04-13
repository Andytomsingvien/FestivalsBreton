/**
 * Initialise une carte Leaflet centrée sur une position donnée et ajoute une tuile de fond OpenStreetMap.
 * Récupère les données des festivals depuis une balise HTML cachée et crée un marqueur pour chaque festival sur la carte.
 *
 * @function initMap
 */
function initMap() {
    console.log("coucou");
    /**
     * @type {L.Map} map - Instance de la carte Leaflet.
     */
    let map = L.map('map').setView([47.8607, -2.9375], 8);

    /**
     * @type {L.TileLayer} tileLayer - Tuile de fond OpenStreetMap.
     */
    let tileLayer = L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    /**
     * @type {HTMLElement} festivalsData - Balise HTML cachée contenant les données des festivals.
     */
    let festivalsData = document.getElementById('festivals-data');

    /**
     * @type {Array<Object>} festivals - Tableau d'objets représentant les festivals.
     */
    let festivals = JSON.parse(festivalsData.getAttribute('data-festivals'));

    /**
     * Crée un marqueur pour chaque festival et l'ajoute à la carte.
     *
     * @function createMarkers
     */
    function createMarkers() {
        for (const festival of festivals) {
            let marker = L.marker([festival.lat, festival.lon]).addTo(map);

            /**
             * @type {L.Popup} popup - Popup affichant les informations du festival.
             */
            let popup = marker.bindPopup(`Bienvenue au festival ${festival.nom} à ${festival.ville}.<br>Toutes les informations sur notre site web : ${festival.url}.`);
        }
    }

    createMarkers();
}

