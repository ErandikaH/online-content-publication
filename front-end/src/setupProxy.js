const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
    app.use(
        '/content/',
        createProxyMiddleware({
            target: 'http://ec2-52-77-223-85.ap-southeast-1.compute.amazonaws.com',
            secure: false,
            changeOrigin: true
        })
    );

    app.use(
        '/content/publish/1',
        createProxyMiddleware({
            target: 'http://ec2-52-77-223-85.ap-southeast-1.compute.amazonaws.com',
            changeOrigin: true
        })
    );

    app.use(
        '/user',
        createProxyMiddleware({
            target: 'http://ec2-52-77-223-85.ap-southeast-1.compute.amazonaws.com',
            changeOrigin: true
        })
    );

    app.use(
        '/content/publications/',
        createProxyMiddleware({
            target: 'http://ec2-52-77-223-85.ap-southeast-1.compute.amazonaws.com',
            changeOrigin: true
        })
    );

};