document.addEventListener('DOMContentLoaded', function() {
    if ('serviceWorker' in navigator) {
        console.log('Service Worker is supported');
        navigator.serviceWorker.register('js/sw.js').then(function(reg) {
            console.log(':^)', reg);
            reg.pushManager.subscribe({
                userVisibleOnly: true
            }).then(function(sub) {
                console.log('endpoint:', sub.endpoint);
            },
            function(error){
                console.log(error)
            });
        }).catch(function(err) {
            console.log(':^(', err);
        });
    }
}, false);