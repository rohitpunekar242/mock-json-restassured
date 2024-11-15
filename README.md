# Mock JSON for Rest Assured

This project includes creating and mocking json response by using REST Assured API Testing. Below is an example JSON response used for a mock API.

## Example JSON Response

```json
{
    "dashboard": {
        "purchaseAmount": 910,
        "website": "rahulshettyacademy.com"
    },
    "courses": [
        {
            "title": "Selenium Python",
            "price": 50,
            "copies": 6
        },
        {
            "title": "Cypress",
            "price": 40,
            "copies": 4
        },
        {
            "title": "RPA",
            "price": 45,
            "copies": 10
        }
    ]
}
 ``` 

## Tests covered in this project for this JSON Structure are:

1. Print No of courses returned by API
2. Print Purchase Amount
3. Print Title of the first course
4. Print All course titles and their respective Prices
5. Print no of copies sold by RPA Course
6. Verify if Sum of all Course prices matches with Purchase Amount

## Test execution report
![TestNG Report](https://github.com/rohitpunekar242/mock-json-restassured/blob/master/TestNG_report.png)

