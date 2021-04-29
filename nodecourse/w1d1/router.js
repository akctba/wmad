const http = require("http");
const fs = require('fs');

const PRE_HTML = "<html><head><title>Node Lab</title></head><body>";
const POS_HTML = "</body></html>";

const router = (req, res) => {

    console.log("This is the request: ", req);

    const url = req.url;
    const method = req.method;

    //“/”, “/read-message” and “/write-message”.
    switch (`${method}:${url}`) {
        case "GET:/":
            res.write(PRE_HTML)
            res.write("<h1>Hello Node!</h1>");
            res.write("<a href='/read-message'>Read message</a> ");
            res.write("<a href='/write-message'>Write message</a> ");
            res.write(POS_HTML);
            break;
        case "GET:/read-message":
            res.write(PRE_HTML)

            res.write(POS_HTML);
            break;
        case "GET:/write-message":
            res.write(PRE_HTML)
            res.write("<p>Type something:</p>");
            res.write("<form method='POST' action='/write-message'>");
            res.write("<input type='text' name='message'>Type something:</p>");
            res.write("<button type='submit'>Submit</button>");
            res.write("</form>");
            res.write(POS_HTML);
            break;
        case "POST:/write-message":
            const body = [];
            req.on("data", chunk => {
                console.log(chunk);
                body.push(chunk);
            });
            return req.on("end", () => {
                const parsedBody = Buffer.concat(body).toString();
                console.log(parsedBody);
                const message = parsedBody.split("=")[1];
                fs.writeFile("message.txt", message, err => {
                    if (err) throw err;
                    res.statusCode = 302;
                    res.setHeader("Location", "/");
                    return res.end();
                });
            });
            break;
        default:
            break;
    }

    return res.end();
};

exports.router = router;
