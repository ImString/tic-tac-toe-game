import { Circle, Svg } from 'react-native-svg';

export default (props: { color: string }) => (
	<Svg width="32" height="32" viewBox="0 0 32 32" fill="none">
		<Circle cx="16" cy="16" r="12" stroke={props.color} stroke-width="4" />
	</Svg>
);
