_CMSC 355 Project \
Rory Stevens, John McDaniel, Tim Mucha, Alan Velasquez, Ogaga Obrimaho_

# Sighting Tracker

## Sprint 1: 
See `DetailedUseCases.pdf` for more details

### Two Use Cases Specified
* New Sighting Screen
  * Users can open the new sighting screen from the main menu.
  * Fields are available for user input.
### Use Cases Implemented
* Search Screen
  * Users can open the search screen from the main menu to search for a sighting.
  * Users can input search criteria into the fields present on the screen.
### Test Cases Planned
* Data capture into objects
  * After user submission on the "Search a Sighting" screen, all data will be verified as properly stored in objects.
  * After user submission on the "New Sighting" screen, all data will be verified as properly stored in objects.

## Sprint 2:
### New Use Cases
* __Use Case/Functionality 1:__ Search - Users can search for sightings based on different criteria
  * **Actor:** User
  * **Entry condition:** The User selects "Search a sighting"
  * **Basic path:** \
     #1. While on the search sightings screen, the user enters a date range and/or coordinate ranges. \
     #2. The user selects the search button. **[E01]** \
     #3. The user can click through returned sightings.
  * **Exception Path:** The system produces an error if input is invalid.
* Use Case/Functionality 2: Corroborate - Users can corroborate existing sightings
  * **Actor:** User
  * **Entry condition:** The User has selected "Browse all sightings"
  * **Basic Path:** \
    #1. While on the browse sightings page, the user can click through records. \
    #2. The user can click 'Corroborate Sighting' to corroborate a sighting. This is saved to the corroborated field. 
  * **Business Rules:**
    * **[BR01]** Corroborate field must be true or false.
  
### Test Cases
#1: User can successfully search for a sighting based on a date range. \
#2: User can successfully corroborate a sighting from the "Browse Sightings" screen