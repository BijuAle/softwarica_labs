var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var villainSchema = new Schema({
    name: {
        type: String,
        required: true
    },
    desc: {
        type: String,
        required: true
    },
    image: {
        type: String,
        default: ''
    }
}, {
        timestamps: true
    });

var Villains = mongoose.model('Villain', villainSchema);
module.exports = Villains;