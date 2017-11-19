var markers = [];
				    	
						function geocodePosition(pos) {
							var geocoder = new google.maps.Geocoder();
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
							  var latLng = new google.maps.LatLng(33.886917, 9.537499);
							  var map = new google.maps.Map(document.getElementById('map'), {
							    zoom: 6,
							    center: latLng,
							    mapTypeId: google.maps.MapTypeId.ROADMAP
							  });
							  var input = document.getElementById('form_event:form_subject');
						        var searchBox = new google.maps.places.SearchBox(input);

						     // Bias the SearchBox results towards current map's viewport.
						        map.addListener('bounds_changed', function() {
						          searchBox.setBounds(map.getBounds());
						        });

						      
						        // Listen for the event fired when the user selects a prediction and retrieve
						        // more details for that place.
						        searchBox.addListener('places_changed', function() {
						          var places = searchBox.getPlaces();

						          if (places.length == 0) {
						            return;
						          }
						       // For each place, get the icon, name and location.
						          var bounds = new google.maps.LatLngBounds();
						          places.forEach(function(place) {
						            if (!place.geometry) {
						              console.log("Returned place contains no geometry");
						              return;
						            }
						            var icon = {
						              url: place.icon,
						              size: new google.maps.Size(71, 71),
						              origin: new google.maps.Point(0, 0),
						              anchor: new google.maps.Point(17, 34),
						              scaledSize: new google.maps.Size(25, 25)
						            };

						            // Create a marker for each place.
						            markers.push(new google.maps.Marker({
						              map: map,
						              icon: icon,
						              title: place.name,
						              position: place.geometry.location
						            }));

						            if (place.geometry.viewport) {
						              // Only geocodes have viewport.
						              bounds.union(place.geometry.viewport);
						            } else {
						              bounds.extend(place.geometry.location);
						            }
						            
							 		 document.getElementById('form_event:form_botcheck').value = place.geometry.location.lat();
							 		 document.getElementById('form_event:form_botcheck1').value = place.geometry.location.lng();
						          });


						          map.fitBounds(bounds);
							
						        });
						      
																		        
						

						        google.maps.event.addListener(map, 'click', function(event) {
							        //place event
									 // var places =searchBox.getPlaces();
									  //var bounds = new google.maps.LatLngBounds();
									  //var i, place;

									 // for ( i = 0; place=places[i];i++) {
										 // console.log(place.geometry.location)
										//bounds.extend(place.geometry.location)
										//marker.setPosition(place.geometry.location);
									//}
									//map.fitBounds(bounds);
									//map.setZoom(15);
										
								  addMarker(event.latLng, map);
								  });
							        
						}
				
						function addMarker(location, map) {
							  for (var i = 0; i < markers.length; i++) {
					             markers[i].setMap(null);
					          }
							  var marker = new google.maps.Marker({
							    position: location,
							    map: map
							  });
							
							  
					
							  var latitud=marker.getPosition().lat();
							  var lng=marker.getPosition().lng();
					
					 		  document.getElementById('form_event:form_botcheck').value = latitud;
					 		 document.getElementById('form_event:form_botcheck1').value = lng;
					 		 //document.getElementById('form_event:form_subject').value = marker.search();
							  markers.push(marker);
						  
						}
			