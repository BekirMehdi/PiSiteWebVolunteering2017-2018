       var lngx =document.getElementById("lng").value;
              var latx =document.getElementById("lat").value;
              var markers = [];
              var geocoder = new google.maps.Geocoder();
			
              function geocodePosition(pos) {
              geocoder.geocode({
              latLng: pos
              }, function(responses) {
              if (responses && responses.length > 0) {
              updateMarkerAddress(responses[0].formatted_address);
              } else {
              updateMarkerAddress('Cannot determine address at this location.');
              }
              });
              }

              function updateMarkerStatus(str) {
              document.getElementById('markerStatus').innerHTML = str;
              }

              function updateMarkerPosition(latLng) {
              document.getElementById('info').innerHTML = [
              latLng.lat(),
              latLng.lng()
              ].join(', ');
              }

                function updateMarkerAddress(str) {
                document.getElementById('address').innerHTML = str;
                }

                function initialize() {
                var latLng = new google.maps.LatLng(latx, lngx);
                
                var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 10,
                center: latLng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
                });

               
                var marker = new google.maps.Marker({
                  position: latLng,
                  map: map
                });
                markers.push(marker);

                }

              
