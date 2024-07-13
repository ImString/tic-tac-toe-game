import { Svg, Rect } from 'react-native-svg';

export default (props: { color: string }) => (
	<Svg width="32" height="32" viewBox="0 0 32 32" fill="none">
		<Rect
			x="25.9779"
			y="3"
			width="4"
			height="32.4957"
			transform="rotate(45 25.9779 3)"
			fill={props.color}
		/>
		<Rect
			width="4"
			height="32.4957"
			transform="matrix(-0.707107 0.707107 0.707107 0.707107 6.32753 3)"
			fill={props.color}
		/>
	</Svg>
);
