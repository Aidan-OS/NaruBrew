document.addEventListener('dragover', function (e) {
    e.preventDefault();
});

document.addEventListener('drop', function (e) {
    e.preventDefault();
});

document.addEventListener('DOMContentLoaded', function () {
    const dropZone = document.getElementById('drop-zone');
    const fileInput = document.getElementById('file-input');
    const previewGrid = document.getElementById('preview-grid');

    if (!dropZone || !fileInput || !previewGrid) return;

    // Click opens file dialog
    dropZone.addEventListener('click', () => fileInput.click());

    // Drag enter/over
    dropZone.addEventListener('dragover', (e) => {
        e.preventDefault();
        e.stopPropagation();
        dropZone.classList.add('dragover');
    });

    // Drag leave
    dropZone.addEventListener('dragleave', (e) => {
        e.preventDefault();
        e.stopPropagation();
        dropZone.classList.remove('dragover');
    });

    // Drop
    dropZone.addEventListener('drop', (e) => {
        e.preventDefault();
        e.stopPropagation();
        dropZone.classList.remove('dragover');
        handleFiles(e.dataTransfer.files);
    });

    // File browser
    fileInput.addEventListener('change', () => {
        handleFiles(fileInput.files);
    });

    function handleFiles(files) {
        [...files].forEach(file => {
            const reader = new FileReader();
            reader.onload = function (e) {
                const div = document.createElement('div');
                div.classList.add('preview-item');

                let mediaHtml = '';
                if (file.type.startsWith('image/')) {
                    mediaHtml = `<img src="${e.target.result}" alt="${file.name}">`;
                } else if (file.type.startsWith('video/')) {
                    mediaHtml = `<video src="${e.target.result}" controls></video>`;
                } else {
                    return;
                }

                div.innerHTML = `
                    <button type="button" class="remove-btn" title="Remove">&times;</button>
                    ${mediaHtml}
                    <input type="text" class="form-control mt-2" placeholder="Tags...">
                `;

                div.querySelector('.remove-btn').addEventListener('click', () => {
                    div.remove();
                });

                previewGrid.appendChild(div);
            };

            reader.readAsDataURL(file);
        });
    }
});
