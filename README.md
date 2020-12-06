# M2-DAAR-PROJECT-3
## CV Bank project: Elasticsearch Index on resumes
You can upload CVs and then query the CV database using one or more key words.
### To run the program:
<ul>
    <li>Run Elasticsearch on your computer.</li>
    <li>Go to the project root directory.</li>
    <li>Run the following command: mvn spring-boot:run (this will run the back end of the application).</li>
    <li>Either install dependencies with "yarn" and run it with "yarn start" or serve the built project in the build directory (this is for the front end part, see https://github.com/Sofiane0308/cv-bank-front).</li>
</ul>

### Notes:
<ul>
    <li>In src/test you will find a Postman collection of some queries to try and some JUnit tests.</li>
    <li>To test the application, you'll find in the resumes folder two CVs in PDF and Word formats, royalty-free.
    <li>This project suppose that the backend is running on http://localhost:8080.</li>
    <li>A part from the front end, you can use http://localhost:8080/deleteAll (POST URL) and http://localhost:8080/findAll (GET URL) to respectively remove and get all the resumes.
</ul>