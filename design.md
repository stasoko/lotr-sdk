# lotr-sdk design

### Overview
This SDK was designed to be lightweight and simple.  It uses the built in Java HttpClient to call endpoints asynchronously.  The complexities involved with using the HttpClient are hidden from the SDK user.  Each SDK method returns a Plain Old Java Object (POJO) or a list of POJOs.  The usage of the Java HttpClient is limited to the LotrHttpClient class.  Another client could be substituted with minimal difficulty.

### Error Conditions
This SDK was designed to provide empty objects or lists, rather than null pointers.  The distinction between missing data and errors will be improved in the future.

### Limitations
This SDK was created during one very long day.  It is incomplete and not as consistent as it should be.  For example, only certain objects can be retrieved by name or sorted.  These capabilities were added as examples and will be implemented throughout in future versions of the SDK.  Many features were not left out due to difficulty or due to oversight, but due to lack of time.

### Future Improvements
Future improvements may include:
- Increased consistency
- Support for callbacks using Observer pattern
- Increased filtering support, including fuzzy matching
- Increased deeper logic using aggregation and abstraction
- Richer sorting capabilities
- Paging capabilities
- Improved error handling
- Better distinction between error cases and cases where there is no data
- Improved, more modern testing, including Mockito
- Link analysis diagrams - connections between characters


