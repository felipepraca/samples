module.exports = {
    configureWebpack: config => {
        config.performance = {
            maxEntrypointSize: 1000 * 1024 // 1000 KiB in bytes
        }
        config.optimization.splitChunks.maxSize = 244 * 1024 // 244 KiB in bytes
        config.optimization.splitChunks.chunks = 'all'
    }
}