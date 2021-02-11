const fs = require('fs');

module.exports = () => {
    const mockData = JSON.parse(fs.readFileSync('mock_data/database.json'));
    mockData.data['projects'].map(project => {
        let maxTeamSize = Math.floor(Math.random() * 10) + 1;
        let generatedUrls = [];
        for (let i = 0; i < maxTeamSize; i++) {
            let num = Math.floor(Math.random() * 99) + 1;
            generatedUrls.push('https://randomuser.me/api/portraits/men/'+num+'.jpg')
        }
        project['teamAvatarUrls'] = generatedUrls;
    });
    return mockData
};