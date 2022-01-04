import logo from './logo.svg';
import './App.css';

	constructor(props) {
		super(props);
		this.state = {employees: []};
	}

	componentDidMount() { (2)
		client({method: 'GET', path: '/api/gpus'}).done(response => {
			this.setState({employees: response.entity._embedded.employees});
		});
	}
